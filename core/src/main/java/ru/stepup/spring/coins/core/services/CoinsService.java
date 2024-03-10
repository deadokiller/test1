package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ExecuteCoinsRequest;
import ru.stepup.spring.coins.core.api.ExecuteCoinsResponse;
import ru.stepup.spring.coins.core.configurations.properties.CoreProperties;
import ru.stepup.spring.coins.core.exceptions.BadRequestException;

@Service
public class CoinsService {
    private final CoreProperties coreProperties;
    private final ExecutorService executorService;
    private final ProductService productService;

    public CoinsService(CoreProperties coreProperties, ExecutorService executorService, ProductService productService) {
        this.coreProperties = coreProperties;
        this.executorService = executorService;
        this.productService = productService;
    }

    public ExecuteCoinsResponse execute(ExecuteCoinsRequest request, Integer userId) {
        if (coreProperties.getNumbersBlockingEnabled()) {
            if (coreProperties.getBlockedNumbers().contains(request.number())) {
                throw new BadRequestException("Указан заблокированный номер кошелька", "BLOCKED_ACCOUNT_NUMBER");
            }
        }

        var products = productService.getUserProduct(userId);
        products.getProductList()
                .stream()
                .filter(p -> p.getProductId().equals(Long.parseLong(request.productId())))
                .filter(p -> p.getBalance() >= 0.0)
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Нет подходящего продукта для исполнения", "PRODUCT_NOT_FOUND"));

        ExecuteCoinsResponse response = executorService.execute(request);
        return response;
    }
}

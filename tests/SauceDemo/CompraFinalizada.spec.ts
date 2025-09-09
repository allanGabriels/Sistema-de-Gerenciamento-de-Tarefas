import { test, expect } from '@playwright/test';

test('Compra finalizada', async ({ page }) => {
    //fazer login
    await page.goto('https://www.saucedemo.com/');
    await page.fill('[data-test="username"]', 'standard_user');
    await page.fill('[data-test="password"]', 'secret_sauce');
    await page.click('[data-test="login-button"]');
    await expect(page).toHaveURL('https://www.saucedemo.com/inventory.html');

    //adicionar coisa no carrinho
    await page.locator('[data-test="add-to-cart-sauce-labs-backpack"]').click();
    await page.locator('[data-test="add-to-cart-sauce-labs-bike-light"]').click();
    await page.locator('[data-test="add-to-cart-sauce-labs-bolt-t-shirt"]').click();

    //abrir o carrinho
    await page.click('.shopping_cart_link');
    await expect(page).toHaveURL('https://www.saucedemo.com/cart.html');

    //clicar para finalizar compra
    await page.click('[data-test="checkout"]');
    await expect(page).toHaveURL('https://www.saucedemo.com/checkout-step-one.html');
    
    //preencher informações
    await page.fill('[data-test="firstName"]', 'João');
    await page.fill('[data-test="lastName"]', 'Choma');
    await page.fill('[data-test="postalCode"]', '9785');

    //ir para o próximo tela
    await page.click('[data-test="continue"]');
    await expect(page).toHaveURL('https://www.saucedemo.com/checkout-step-two.html');

    //finalizar compra
    await page.click('[data-test="finish"]');
    await expect(page).toHaveURL('https://www.saucedemo.com/checkout-complete.html');

});

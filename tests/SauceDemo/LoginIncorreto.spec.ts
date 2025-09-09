import { test, expect } from '@playwright/test';

test('Login não realizado', async ({ page }) => {
  await page.goto('https://www.saucedemo.com/');
  await page.fill('[data-test="username"]', 'João Choma');
  await page.fill('[data-test="password"]', 'Neto');
  await page.click('[data-test="login-button"]');
  
  // aguarda a msg de erro
  await expect(page.locator('[data-test="error"]'))
    .toContainText('Username and password do not match');
});

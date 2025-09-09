import { test, expect } from '@playwright/test';

test('Login bem-sucedido — The Internet Herokuapp', async ({ page }) => {
  
  await page.goto('https://the-internet.herokuapp.com/login');

  
  await page.fill('#username', 'tomsmith');
  await page.fill('#password', 'SuperSecretPassword!');

  await page.click('button[type="submit"]');

  await expect(page.locator('h2')).toContainText('Secure Area');
});

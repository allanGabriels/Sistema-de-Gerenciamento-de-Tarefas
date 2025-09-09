import { test, expect } from '@playwright/test';

test('Login com senha incorreta', async ({ page }) => {
  await page.goto('https://practicetestautomation.com/practice-test-login');

  await page.fill('input[name="username"]', 'student');
  await page.fill('input[name="password"]', 'WrongPassword');

  await page.click('button#submit');

  await expect(page).toHaveURL('https://practicetestautomation.com/practice-test-login/');
  await expect(page.locator('#error')).toContainText('Your password is invalid!');
});
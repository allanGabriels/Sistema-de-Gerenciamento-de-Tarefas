import { test, expect } from '@playwright/test';

test('Login correto', async ({ page }) => {
  await page.goto('https://practicetestautomation.com/practice-test-login');

  await page.fill('input[name="username"]', 'student');
  await page.fill('input[name="password"]', 'Password123');

  await page.click('button#submit');

  await expect(page).toHaveURL(/logged-in-successfully/);
});
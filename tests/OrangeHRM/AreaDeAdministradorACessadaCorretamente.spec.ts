import { test, expect } from '@playwright/test';

test('Acesso ao painel de administração após login', async ({ page }) => {
  await page.goto('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');

  await page.fill('input[name="username"]', 'Admin');
  await page.fill('input[name="password"]', 'admin123');


  await page.click('button[type="submit"]');
  await page.waitForURL('**/web/index.php/dashboard/index');
  await expect(page.locator('h6')).toHaveText('Dashboard');

  await page.goto('https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers');

  await expect(page).toHaveURL('https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers');
});
import { test, expect } from '@playwright/test';

test.describe('Login — The Internet Herokuapp', () => {

  test('Login incorreto', async ({ page }) => {
    await page.goto('https://the-internet.herokuapp.com/login');

    // Credenciais erradas
    await page.fill('#username', 'usuario_invalido');
    await page.fill('#password', 'senha_errada');
    await page.click('button[type="submit"]');

    // Verifica se continuamos na página de login
    await expect(page).toHaveURL('https://the-internet.herokuapp.com/login');
  });

  test('Mensagem de erro exibida', async ({ page }) => {
    await page.goto('https://the-internet.herokuapp.com/login');

    // Tentativa errada
    await page.fill('#username', 'tomsmith');
    await page.fill('#password', 'errada');
    await page.click('button[type="submit"]');

    // Verifica se a mensagem de erro aparece
    await expect(page.locator('#flash'))
      .toContainText('Your password is invalid!');
  });

});

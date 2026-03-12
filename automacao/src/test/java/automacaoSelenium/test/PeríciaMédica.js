const { Builder, By, until } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const assert = require('assert');

describe('Perícia Médica Test', function() {
    this.timeout(30000); // Set timeout to 30 seconds
    let driver;
    let dsl;

    before(async function() {
        driver = await new Builder().forBrowser('chrome').build();
        dsl = new AcessoPericiaMedicaTest(driver);
    });

    after(async function() {
        await driver.quit();
    });

    it('TC005 - Cadastrar Usuário Operador Perícia Médica', async function() {
        await dsl.efetuarLogin();
    });

});

class AcessoPericiaMedicaTest {
    constructor(driver) {
        this.driver = driver;
    }

    /**
     * Hellow
     * @param
     */
    async efetuarLogin() {
        await dsl.efeturarLogin();
    }
}

module.exports = AcessoPericiaMedicaTest;
import {Target} from '@serenity-js/protractor';
import {by} from 'protractor';

export class LeanPageObjects {
    static loginBotton = Target.the('Botao Login').located(by.css(`input[data-test="login-button"]`))
    static inputUsername = Target.the('Campo Username').located(by.css(`input[data-test="username"]`))
    static inputPassword = Target.the('Campo Password').located(by.css(`input[data-test="password"]`))
    static boxErrorLocator = Target.the('Mensagem de erro').located(by.css(`h3[data-test="error"]`))
    static boxErrorMessage = 'Epic sadface: Sorry, this user has been locked out.'
    
    static imageBackpack = Target.the('Imagem Sauce Labs Backpack').located(by.css(`img[alt="Sauce Labs Backpack"]`))
    static imageBolt = Target.the('Imagem Sauce Labs Bolt T-Shirt').located(by.css(`img[alt="Sauce Labs Bolt T-Shirt"]`))
    static imageOnesie = Target.the('Imagem Sauce Labs Onesie').located(by.css(`img[alt="Sauce Labs Onesie"]`))
    static imageBike = Target.the('Imagem Sauce Labs Bike Light').located(by.css(`img[alt="Sauce Labs Bike Light"]`))
    static imageFleece = Target.the('Imagem Sauce Labs Fleece Jacket').located(by.css(`img[alt="Sauce Labs Fleece Jacket"]`))
    static imageTShirt = Target.the('Imagem Test.allTheThings() T-Shirt (Red)').located(by.css(`img[alt="Test.allTheThings() T-Shirt (Red)"]`))
    
    static srcBackPack = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg'
    static srcimageProblem = '/static/media/sl-404.168b1cce.jpg'
    
}

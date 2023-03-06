const elements = require('./elements').ELEMENTS

class Login{

    acessarPagina(){
        cy.visit("/")
    }

    digitarUsuario(usuario){
        cy.get(elements.username).type(usuario)
    }

    digitarSenha(senha){
        cy.get(elements.password).type(senha)
    }

    clicarLogin(){
        cy.get(elements.loginButton).click()
    }

    verificarItem(item){
        let aux = 0
        let src = ''
        switch(item){
            case 'Sauce Labs Backpack':
            aux = 0
            src = '/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg'
            break
            case 'Sauce Labs Bike Light':
            aux = 1
            src = '/static/media/bike-light-1200x1500.a0c9caae.jpg'
            break
            case 'Sauce Labs Bolt T-Shirt':
            aux = 2
            src = '/static/media/bolt-shirt-1200x1500.c0dae290.jpg'
            break
            case 'Sauce Labs Fleece Jacket':
            aux = 3
            src = '/static/media/sauce-pullover-1200x1500.439fc934.jpg'
            break
            case 'Sauce Labs Bolt Onesie':
            aux = 4
            src = '/static/media/red-onesie-1200x1500.1b15e1fa.jpg'
            break
            case 'Test.allTheThings() T-Shirt (Red)':
            aux = 5
            src = '/static/media/red-tatt-1200x1500.e32b4ef9.jpg'
            break
        }
        cy.get(elements.inventoryItem).eq(aux).should('have.text',item)
        cy.get('img[src="'+src+'"]').should('be.visible')
    }

    verificarMensagem(mensagem){
        cy.contains(mensagem).should('be.visible')
    }

    verificarImagensCachorro(){
        //Não foi utilizado um loop justamente para representar a utilizade dos Page Objects
        cy.get(elements.dogImage).eq(0).should('be.visible')
        cy.get(elements.dogImage).eq(1).should('be.visible')
        cy.get(elements.dogImage).eq(2).should('be.visible')
        cy.get(elements.dogImage).eq(3).should('be.visible')
        cy.get(elements.dogImage).eq(4).should('be.visible')
        cy.get(elements.dogImage).eq(5).should('be.visible')
    }
}

export default new Login()
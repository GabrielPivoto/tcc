Given(/^que a página Sauce Demo foi acessada$/, () => {
	cy.visit("/")
});

When(/^o usuário "([^"]*)" é digitado$/, (username) => {
  cy.get('#user-name').type(username)
});

When(/^a senha "([^"]*)" é digitada$/, (senha) => {
	cy.get('#password').type(senha)
});

When(/^o botão LOGIN é pressionado$/, () => {
	cy.get('#login-button').click()
});

Then(/^a "([^"]*)" deve estar disponível$/, (item) => {
  let aux = 0
  let src = ''
  switch(item){
    case 'Sauce Labs Backpack':
      aux = 0
      src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg'
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
	cy.get('.inventory_item_name').eq(aux).should('have.text',item)
  cy.get('img[src="'+src+'"]').should('be.visible')
});

Then(/^a mensagem de erro deve ser apresentada$/, () => {
	cy.contains('Epic sadface: Sorry, this user has been locked out.').should('be.visible')
});

Then(/^as imagens de cachorro devem ser apresentadas$/, () => {
  //Não foi utilizado um loop justamente para representar a utilizade dos Page Objects
	cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(0).should('be.visible')
  cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(1).should('be.visible')
  cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(2).should('be.visible')
  cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(3).should('be.visible')
  cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(4).should('be.visible')
  cy.get('img[src="/static/media/sl-404.168b1cce.jpg"]').eq(5).should('be.visible')
});
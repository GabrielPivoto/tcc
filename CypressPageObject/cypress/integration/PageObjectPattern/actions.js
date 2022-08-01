import Login from "../../support/Pages/Login";


Given(/^que a página Sauce Demo foi acessada$/, () => {
	Login.acessarPagina()
});

When(/^o usuário "([^"]*)" é digitado$/, (usuario) => {
	Login.digitarUsuario(usuario)
});

When(/^a senha "([^"]*)" é digitada$/, (senha) => {
	Login.digitarSenha(senha)
});

When(/^o botão LOGIN é pressionado$/, () => {
	Login.clicarLogin()
});

Then(/^a "([^"]*)" deve estar disponível$/, (item) => {
	Login.verificarItem(item)
});

Then(/^a mensagem "([^"]*)" deve ser apresentada$/, (mensagem) => {
	Login.verificarMensagem(mensagem)
});

Then(/^as imagens de cachorro devem ser apresentadas$/, () => {
	Login.verificarImagensCachorro()
});

/* eslint-disable unicorn/filename-case */
import { Given, Then, When } from '@cucumber/cucumber';
import { Ensure, equals, includes } from '@serenity-js/assertions';
import { actorCalled, actorInTheSpotlight } from '@serenity-js/core';
import { Navigate, Wait, isVisible, Press, Click, Attribute, Text, UseAngular } from '@serenity-js/protractor';

import { LeanPageObjects } from '../support';

Given('que {word} acessou a página do Sauce Demo', (actorName: string) =>
    actorCalled(actorName).attemptsTo(
        UseAngular.disableSynchronisation(),
        Navigate.to('https://www.saucedemo.com/'),
        Wait.until(LeanPageObjects.loginBotton, isVisible())
    ));

When('o usuário {word} é digitado', (username: string) =>
    actorInTheSpotlight().attemptsTo(
        Press.the(username).in(LeanPageObjects.inputUsername),
    ));

When('a senha {word} é digitada', (password: string) =>
    actorInTheSpotlight().attemptsTo(
        Press.the(password).in(LeanPageObjects.inputPassword),
    ));

When('o botão LOGIN é pressionado', () =>
    actorInTheSpotlight().attemptsTo(
        Click.on(LeanPageObjects.loginBotton),
    ));

Then('a Sauce Labs Backpack deve estar disponível', () =>
    actorInTheSpotlight().attemptsTo(
        Wait.until(LeanPageObjects.imageBackpack, isVisible()),
        Ensure.that(Attribute.of(LeanPageObjects.imageBackpack).called('src'), includes(LeanPageObjects.srcBackPack))   
    ));

Then('a mensagem Epic sadface: Sorry, this user has been locked out. deve ser apresentada', () =>
    actorInTheSpotlight().attemptsTo(
        Wait.until(LeanPageObjects.boxErrorLocator, isVisible()),
        Ensure.that(Text.of(LeanPageObjects.boxErrorLocator), equals(LeanPageObjects.boxErrorMessage))   
    ));

Then('as imagens de cachorro devem ser apresentadas', () =>
    actorInTheSpotlight().attemptsTo(
        Wait.until(LeanPageObjects.imageBackpack, isVisible()),
        Ensure.that(Attribute.of(LeanPageObjects.imageBackpack).called('src'), includes(LeanPageObjects.srcimageProblem)),
        Ensure.that(Attribute.of(LeanPageObjects.imageBolt).called('src'), includes(LeanPageObjects.srcimageProblem)),
        Ensure.that(Attribute.of(LeanPageObjects.imageOnesie).called('src'), includes(LeanPageObjects.srcimageProblem)),
        Ensure.that(Attribute.of(LeanPageObjects.imageBike).called('src'), includes(LeanPageObjects.srcimageProblem)),
        Ensure.that(Attribute.of(LeanPageObjects.imageFleece).called('src'), includes(LeanPageObjects.srcimageProblem)),
        Ensure.that(Attribute.of(LeanPageObjects.imageTShirt).called('src'), includes(LeanPageObjects.srcimageProblem))   
    ));
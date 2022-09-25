import 'mocha';

import { Ensure, includes, equals } from '@serenity-js/assertions';
import { actorCalled, engage } from '@serenity-js/core';
import { Navigate, UseAngular, Wait, Text, isVisible, Click, Press, Attribute } from '@serenity-js/protractor';

import { Actors, LeanPageObjects } from '../src';

describe('Login sem Cucumber', () => {

    beforeEach(() => engage(new Actors()));

    it('Login como Standard User', () =>
        actorCalled('standard_user').attemptsTo(
            UseAngular.disableSynchronisation(),
            Navigate.to('https://www.saucedemo.com/'),
            Wait.until(LeanPageObjects.loginBotton, isVisible()),
            Press.the('standard_user').in(LeanPageObjects.inputUsername),
            Press.the('secret_sauce').in(LeanPageObjects.inputPassword),
            Click.on(LeanPageObjects.loginBotton),
            Wait.until(LeanPageObjects.imageBackpack, isVisible()),
            Ensure.that(Attribute.of(LeanPageObjects.imageBackpack).called('src'), includes(LeanPageObjects.srcBackPack))
    ));
    
    it('Login como Locked Out User', () =>
        actorCalled('locked_out_user').attemptsTo(
            UseAngular.disableSynchronisation(),
            Navigate.to('https://www.saucedemo.com/'),
            Wait.until(LeanPageObjects.loginBotton, isVisible()),
            Press.the('locked_out_user').in(LeanPageObjects.inputUsername),
            Press.the('secret_sauce').in(LeanPageObjects.inputPassword),
            Click.on(LeanPageObjects.loginBotton),
            Wait.until(LeanPageObjects.boxErrorLocator, isVisible()),
            Ensure.that(Text.of(LeanPageObjects.boxErrorLocator), equals(LeanPageObjects.boxErrorMessage))
    ));
    
    it('Login como Problem User', () =>
        actorCalled('problem_user').attemptsTo(
            UseAngular.disableSynchronisation(),
            Navigate.to('https://www.saucedemo.com/'),
            Wait.until(LeanPageObjects.loginBotton, isVisible()),
            Press.the('problem_user').in(LeanPageObjects.inputUsername),
            Press.the('secret_sauce').in(LeanPageObjects.inputPassword),
            Click.on(LeanPageObjects.loginBotton),
            Wait.until(LeanPageObjects.imageBackpack, isVisible()),
            Ensure.that(Attribute.of(LeanPageObjects.imageBackpack).called('src'), includes(LeanPageObjects.srcimageProblem)),
            Ensure.that(Attribute.of(LeanPageObjects.imageBolt).called('src'), includes(LeanPageObjects.srcimageProblem)),
            Ensure.that(Attribute.of(LeanPageObjects.imageOnesie).called('src'), includes(LeanPageObjects.srcimageProblem)),
            Ensure.that(Attribute.of(LeanPageObjects.imageBike).called('src'), includes(LeanPageObjects.srcimageProblem)),
            Ensure.that(Attribute.of(LeanPageObjects.imageFleece).called('src'), includes(LeanPageObjects.srcimageProblem)),
            Ensure.that(Attribute.of(LeanPageObjects.imageTShirt).called('src'), includes(LeanPageObjects.srcimageProblem))
    ));
    
    it('Login como Performance Glitch User', () =>
        actorCalled('performance_glitch_user').attemptsTo(
            UseAngular.disableSynchronisation(),
            Navigate.to('https://www.saucedemo.com/'),
            Wait.until(LeanPageObjects.loginBotton, isVisible()),
            Press.the('performance_glitch_user').in(LeanPageObjects.inputUsername),
            Press.the('secret_sauce').in(LeanPageObjects.inputPassword),
            Click.on(LeanPageObjects.loginBotton),
            Wait.until(LeanPageObjects.imageBackpack, isVisible()),
            Ensure.that(Attribute.of(LeanPageObjects.imageBackpack).called('src'), includes(LeanPageObjects.srcBackPack))
    ));    
});

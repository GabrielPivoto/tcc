import { Before, defineParameterType, setDefaultTimeout } from '@cucumber/cucumber';
import { actorCalled, actorInTheSpotlight, engage } from '@serenity-js/core';
import { Actors } from './Actors';

Before(() => engage(new Actors()));

setDefaultTimeout(15000);

defineParameterType({
    regexp: /[A-Z][a-z]+/,
    transformer(name: string) {
        return actorCalled(name);
    },
    name: 'actor',
});

defineParameterType({
    regexp: /he|she|they|his|her|their/,
    transformer() {
        return actorInTheSpotlight();
    },
    name: 'pronoun',
});
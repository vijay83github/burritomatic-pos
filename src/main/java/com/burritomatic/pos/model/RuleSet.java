package com.burritomatic.pos.model;


import java.util.HashMap;
import java.util.Map;

public class RuleSet {
    private Map<Integer, Rule> rules;
    RuleSet(){
        rules = new HashMap<Integer, Rule>();
        rules.put(1, new Rule("The Burrito-in-a-bowl product can NOT have a tortilla"));

        rules.put(2, new Rule("On all products, rice is optional"));

        rules.put(3, new Rule("On all products, you can select only ONE meat ingredient"));

        rules.put(4, new Rule("On the 2-ingredient burrito, you may select (1) meat and (1) salsa"));

        rules.put(5, new Rule("On the 3-ingredient burrito, you may select (1) meat, (1) salsa, and (1) topping"));

        rules.put(6, new Rule("There is an additional charge for Guacamole ($1.25)"));

        rules.put(7, new Rule("There is an additional charge for Queso ($1.50)"));

    }

    public Map<Integer, Rule> getRules() {
        return rules;
    }

    public void setRules(Map<Integer, Rule> rules) {
        this.rules = rules;
    }

    public Rule getRuleById(Integer id){
        return rules.get(id);
    }
}

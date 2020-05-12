package com.epam.jolt.converter;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.epam.jolt.ui.Window;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Converter implements ActionListener {

    private final Window joltWindow;

    public Converter(Window joltWindow) {
        this.joltWindow = joltWindow;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement element = JsonParser.parseString(
                joltTransform(
                        joltWindow.getInput().getText(),
                        joltWindow.getJolt().getText()
                ));
        joltWindow.getOutput().setText(gson.toJson(element));
    }

    private String joltTransform(String jsonInput, String jsonJolt) {
        List<Object> spec = JsonUtils.jsonToList(jsonJolt);
        Chainr chainr = Chainr.fromSpec(spec);
        Object input = JsonUtils.jsonToObject(jsonInput);
        Object transform = chainr.transform(input);
        return transform.toString();
    }

}

package com.alextroy.tf_alextroy;

import com.alextroy.tf_alextroy.model.Currency;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

//public class CurrencyDeserializer implements JsonDeserializer<Currency> {
//    @Override
//    public Currency deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        Currency currency = new Currency();
//
//        currency.base = json.getAsJsonObject().get("base").toString();
//        currency.date = json.getAsJsonObject().get("date").toString();
//
//        return currency;
//    }
//}

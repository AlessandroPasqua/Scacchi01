
package it.unibas.scacchi.modello;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class PezzoAdapter implements JsonSerializer<Pezzo>, JsonDeserializer<Pezzo>{
    public static final String CLASSNAME = "CLASSNAME";
    public static final String DATA = "DATA";
    
    
    @Override
    public JsonElement serialize(Pezzo pezzo, Type tipo, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, pezzo.getClass().getName());
        jsonObject.add(DATA, context.serialize(pezzo));
        return jsonObject;
    }

    @Override
    public Pezzo deserialize(JsonElement je, Type tipo, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.getAsJsonPrimitive(CLASSNAME);
        String className = prim.getAsString();
        Class klass = getObjectClass(className);
        return context.deserialize(jsonObject.get(DATA), klass);
    }

    private Class getObjectClass(String className) {
        try {
            return Class.forName(className);
        }catch(ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
}

package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    public final MethodChannel channel;
    final MethodChannel.MethodCallHandler parsingMethodHandler;
    private TextInputMethodHandler textInputMethodHandler;

    public static class Configuration {
        public final String actionLabel;
        public final boolean autocorrect;
        public final Autofill autofill;
        public final String[] contentCommitMimeTypes;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        public final Configuration[] fields;
        public final Integer inputAction;
        public final InputType inputType;
        public final boolean obscureText;
        public final TextCapitalization textCapitalization;

        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(String str, String[] strArr, String str2, TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            public static Autofill fromJson(JSONObject jSONObject) throws JSONException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    strArr[i8] = translateAutofillHint(jSONArray.getString(i8));
                }
                return new Autofill(string, strArr, string2, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String translateAutofillHint(java.lang.String r17) {
                /*
                    Method dump skipped, instruction units count: 802
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }
        }

        public Configuration(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, TextCapitalization textCapitalization, InputType inputType, Integer num, String str, Autofill autofill, String[] strArr, Configuration[] configurationArr) {
            this.obscureText = z7;
            this.autocorrect = z8;
            this.enableSuggestions = z9;
            this.enableIMEPersonalizedLearning = z10;
            this.enableDeltaModel = z11;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill;
            this.contentCommitMimeTypes = strArr;
            this.fields = configurationArr;
        }

        public static Configuration fromJson(JSONObject jSONObject) throws JSONException {
            Configuration[] configurationArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                configurationArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                Configuration[] configurationArr2 = new Configuration[length];
                for (int i8 = 0; i8 < length; i8++) {
                    configurationArr2[i8] = fromJson(jSONArray.getJSONObject(i8));
                }
                configurationArr = configurationArr2;
            }
            Integer numInputActionFromTextInputAction = inputActionFromTextInputAction(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i9 = 0; i9 < jSONArray2.length(); i9++) {
                    arrayList.add(jSONArray2.optString(i9));
                }
            }
            return new Configuration(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), TextCapitalization.fromValue(jSONObject.getString("textCapitalization")), InputType.fromJson(jSONObject.getJSONObject("inputType")), numInputActionFromTextInputAction, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : Autofill.fromJson(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), configurationArr);
        }

        private static Integer inputActionFromTextInputAction(String str) {
            str.hashCode();
            switch (str) {
                case "TextInputAction.unspecified":
                    return 0;
                case "TextInputAction.done":
                    return 6;
                case "TextInputAction.next":
                    return 5;
                case "TextInputAction.none":
                    return 1;
                case "TextInputAction.send":
                    return 4;
                case "TextInputAction.search":
                    return 3;
                case "TextInputAction.go":
                    return 2;
                case "TextInputAction.newline":
                    return 1;
                case "TextInputAction.previous":
                    return 7;
                default:
                    return 0;
            }
        }
    }

    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        public final TextInputType type;

        public InputType(TextInputType textInputType, boolean z7, boolean z8) {
            this.type = textInputType;
            this.isSigned = z7;
            this.isDecimal = z8;
        }

        public static InputType fromJson(JSONObject jSONObject) {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");

        private final String encodedName;

        TextCapitalization(String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        public final String text;

        public TextEditState(String str, int i8, int i9, int i10, int i11) {
            if (!(i8 == -1 && i9 == -1) && (i8 < 0 || i9 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i8) + ", " + String.valueOf(i9) + ")");
            }
            if (!(i10 == -1 && i11 == -1) && (i10 < 0 || i10 > i11)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i10) + ", " + String.valueOf(i11) + ")");
            }
            if (i11 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i10));
            }
            if (i8 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i8));
            }
            if (i9 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i9));
            }
            this.text = str;
            this.selectionStart = i8;
            this.selectionEnd = i9;
            this.composingStart = i10;
            this.composingEnd = i11;
        }

        public static TextEditState fromJson(JSONObject jSONObject) {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i8 = this.composingStart;
            return i8 >= 0 && this.composingEnd > i8;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z7);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i8, Configuration configuration);

        void setEditableSizeAndTransform(double d8, double d9, double[] dArr);

        void setEditingState(TextEditState textEditState);

        void setPlatformViewClient(int i8, boolean z7);

        void show();
    }

    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none"),
        WEB_SEARCH("TextInputType.webSearch"),
        TWITTER("TextInputType.twitter");

        private final String encodedName;

        TextInputType(String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Bundle bundle;
                if (TextInputChannel.this.textInputMethodHandler == null) {
                }
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                str.hashCode();
                byte b8 = -1;
                switch (str.hashCode()) {
                    case -1779068172:
                        if (str.equals("TextInput.setPlatformViewClient")) {
                            b8 = 0;
                        }
                        break;
                    case -1015421462:
                        if (str.equals("TextInput.setEditingState")) {
                            b8 = 1;
                        }
                        break;
                    case -37561188:
                        if (str.equals("TextInput.setClient")) {
                            b8 = 2;
                        }
                        break;
                    case 270476819:
                        if (str.equals("TextInput.hide")) {
                            b8 = 3;
                        }
                        break;
                    case 270803918:
                        if (str.equals("TextInput.show")) {
                            b8 = 4;
                        }
                        break;
                    case 649192816:
                        if (str.equals("TextInput.sendAppPrivateCommand")) {
                            b8 = 5;
                        }
                        break;
                    case 1204752139:
                        if (str.equals("TextInput.setEditableSizeAndTransform")) {
                            b8 = 6;
                        }
                        break;
                    case 1727570905:
                        if (str.equals("TextInput.finishAutofillContext")) {
                            b8 = 7;
                        }
                        break;
                    case 1904427655:
                        if (str.equals("TextInput.clearClient")) {
                            b8 = 8;
                        }
                        break;
                    case 2113369584:
                        if (str.equals("TextInput.requestAutofill")) {
                            b8 = 9;
                        }
                        break;
                }
                try {
                    switch (b8) {
                        case 0:
                            JSONObject jSONObject = (JSONObject) obj;
                            TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                            result.success(null);
                            break;
                        case 1:
                            TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result.success(null);
                            break;
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                                result.success(null);
                            } catch (NoSuchFieldException e8) {
                                e = e8;
                                result.error("error", e.getMessage(), null);
                                return;
                            }
                            break;
                        case 3:
                            TextInputChannel.this.textInputMethodHandler.hide();
                            result.success(null);
                            break;
                        case 4:
                            TextInputChannel.this.textInputMethodHandler.show();
                            result.success(null);
                            break;
                        case 5:
                            JSONObject jSONObject2 = (JSONObject) obj;
                            String string = jSONObject2.getString("action");
                            String string2 = jSONObject2.getString("data");
                            if (string2 == null || string2.isEmpty()) {
                                bundle = null;
                            } else {
                                bundle = new Bundle();
                                bundle.putString("data", string2);
                            }
                            TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                            result.success(null);
                            break;
                        case 6:
                            JSONObject jSONObject3 = (JSONObject) obj;
                            double d8 = jSONObject3.getDouble("width");
                            double d9 = jSONObject3.getDouble("height");
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                            double[] dArr = new double[16];
                            for (int i8 = 0; i8 < 16; i8++) {
                                dArr[i8] = jSONArray2.getDouble(i8);
                            }
                            TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d8, d9, dArr);
                            result.success(null);
                            break;
                        case 7:
                            TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                            result.success(null);
                            break;
                        case 8:
                            TextInputChannel.this.textInputMethodHandler.clearClient();
                            result.success(null);
                            break;
                        case 9:
                            TextInputChannel.this.textInputMethodHandler.requestAutofill();
                            result.success(null);
                            break;
                        default:
                            result.notImplemented();
                            break;
                    }
                } catch (JSONException e9) {
                    e = e9;
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    private static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<TextEditingDelta> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        map.put("deltas", jSONArray);
        return map;
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i8, int i9, int i10, int i11) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i8));
        map.put("selectionExtent", Integer.valueOf(i9));
        map.put("composingBase", Integer.valueOf(i10));
        map.put("composingExtent", Integer.valueOf(i11));
        return map;
    }

    public void commitContent(int i8, Map<String, Object> map) {
        Log.v(TAG, "Sending 'commitContent' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.commitContent", map));
    }

    public void done(int i8) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.done"));
    }

    public void go(int i8) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.go"));
    }

    public void newline(int i8) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.newline"));
    }

    public void next(int i8) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.next"));
    }

    public void performPrivateCommand(int i8, String str, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i8), map));
    }

    public void previous(int i8) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.previous"));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void search(int i8) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.search"));
    }

    public void send(int i8) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.send"));
    }

    public void setTextInputMethodHandler(TextInputMethodHandler textInputMethodHandler) {
        this.textInputMethodHandler = textInputMethodHandler;
    }

    public void unspecifiedAction(int i8) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i8), "TextInputAction.unspecified"));
    }

    public void updateEditingState(int i8, String str, int i9, int i10, int i11, int i12) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i9 + "\nSelection end: " + i10 + "\nComposing start: " + i11 + "\nComposing end: " + i12);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i8), createEditingStateJSON(str, i9, i10, i11, i12)));
    }

    public void updateEditingStateWithDeltas(int i8, ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i8), createEditingDeltaJSON(arrayList)));
    }

    public void updateEditingStateWithTag(int i8, HashMap<String, TextEditState> map) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(map.size()) + " field(s).");
        HashMap map2 = new HashMap();
        for (Map.Entry<String, TextEditState> entry : map.entrySet()) {
            TextEditState value = entry.getValue();
            map2.put(entry.getKey(), createEditingStateJSON(value.text, value.selectionStart, value.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i8), map2));
    }
}

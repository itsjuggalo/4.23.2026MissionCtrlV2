package q7;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class G {
    public static final C a(Number value, String key, String output) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(output, "output");
        return e(-1, m(value, key, output));
    }

    public static final E b(Number value, String output) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(output, "output");
        return new E("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(output, 0, 1, null)));
    }

    public static final E c(Number value, String key, String output) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(output, "output");
        return new E(m(value, key, output));
    }

    public static final E d(m7.e keyDescriptor) {
        AbstractC2304t.f(keyDescriptor, "keyDescriptor");
        return new E("Value of type '" + keyDescriptor.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.i() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final C e(int i8, String message) {
        AbstractC2304t.f(message, "message");
        if (i8 >= 0) {
            message = "Unexpected JSON token at offset " + i8 + ": " + message;
        }
        return new C(message);
    }

    public static final C f(int i8, String message, CharSequence input) {
        AbstractC2304t.f(message, "message");
        AbstractC2304t.f(input, "input");
        return e(i8, message + "\nJSON input: " + ((Object) j(input, i8)));
    }

    public static final C g(String key, String input) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(input, "input");
        return e(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) k(input, 0, 1, null)));
    }

    public static final Void h(AbstractC2643a abstractC2643a, String entity) {
        AbstractC2304t.f(abstractC2643a, "<this>");
        AbstractC2304t.f(entity, "entity");
        abstractC2643a.w("Trailing comma before the end of JSON " + entity, abstractC2643a.f22858a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new C2480h();
    }

    public static /* synthetic */ Void i(AbstractC2643a abstractC2643a, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "object";
        }
        return h(abstractC2643a, str);
    }

    public static final CharSequence j(CharSequence charSequence, int i8) {
        AbstractC2304t.f(charSequence, "<this>");
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i8 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i9 = i8 - 30;
        int i10 = i8 + 30;
        return (i9 <= 0 ? "" : ".....") + charSequence.subSequence(H5.i.b(i9, 0), H5.i.d(i10, charSequence.length())).toString() + (i10 >= charSequence.length() ? "" : ".....");
    }

    public static /* synthetic */ CharSequence k(CharSequence charSequence, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = -1;
        }
        return j(charSequence, i8);
    }

    public static final Void l(AbstractC2643a abstractC2643a, Number result) {
        AbstractC2304t.f(abstractC2643a, "<this>");
        AbstractC2304t.f(result, "result");
        AbstractC2643a.x(abstractC2643a, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new C2480h();
    }

    public static final String m(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(str2, 0, 1, null));
    }
}

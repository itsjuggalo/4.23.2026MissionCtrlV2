package L3;

import W2.C0739g;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class E {
    public static final A a(Number value, String key, String output) {
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(output, "output");
        return e(-1, k(value, key, output));
    }

    public static final C b(Number value, String output) {
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(output, "output");
        return new C("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) i(output, 0, 1, null)));
    }

    public static final C c(Number value, String key, String output) {
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(output, "output");
        return new C(k(value, key, output));
    }

    public static final C d(H3.e keyDescriptor) {
        kotlin.jvm.internal.r.f(keyDescriptor, "keyDescriptor");
        return new C("Value of type '" + keyDescriptor.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.e() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final A e(int i4, String message) {
        kotlin.jvm.internal.r.f(message, "message");
        if (i4 >= 0) {
            message = "Unexpected JSON token at offset " + i4 + ": " + message;
        }
        return new A(message);
    }

    public static final A f(int i4, String message, CharSequence input) {
        kotlin.jvm.internal.r.f(message, "message");
        kotlin.jvm.internal.r.f(input, "input");
        return e(i4, message + "\nJSON input: " + ((Object) h(input, i4)));
    }

    public static final A g(String key, String input) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(input, "input");
        return e(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) i(input, 0, 1, null)));
    }

    public static final CharSequence h(CharSequence charSequence, int i4) {
        if (charSequence.length() >= 200) {
            if (i4 != -1) {
                int i5 = i4 - 30;
                int i6 = i4 + 30;
                return (i5 <= 0 ? "" : ".....") + charSequence.subSequence(AbstractC1681l.b(i5, 0), AbstractC1681l.d(i6, charSequence.length())).toString() + (i6 >= charSequence.length() ? "" : ".....");
            }
            int length = charSequence.length() - 60;
            if (length > 0) {
                return "....." + charSequence.subSequence(length, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static /* synthetic */ CharSequence i(CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = -1;
        }
        return h(charSequence, i4);
    }

    public static final Void j(AbstractC0378a abstractC0378a, Number result) {
        kotlin.jvm.internal.r.f(abstractC0378a, "<this>");
        kotlin.jvm.internal.r.f(result, "result");
        AbstractC0378a.y(abstractC0378a, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new C0739g();
    }

    public static final String k(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) i(str2, 0, 1, null));
    }
}

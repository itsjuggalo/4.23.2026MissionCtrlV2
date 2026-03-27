package t6;

import E5.C0462g;

/* JADX INFO: loaded from: classes2.dex */
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

    public static final C d(p6.e keyDescriptor) {
        kotlin.jvm.internal.r.f(keyDescriptor, "keyDescriptor");
        return new C("Value of type '" + keyDescriptor.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.e() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final A e(int i7, String message) {
        kotlin.jvm.internal.r.f(message, "message");
        if (i7 >= 0) {
            message = "Unexpected JSON token at offset " + i7 + ": " + message;
        }
        return new A(message);
    }

    public static final A f(int i7, String message, CharSequence input) {
        kotlin.jvm.internal.r.f(message, "message");
        kotlin.jvm.internal.r.f(input, "input");
        return e(i7, message + "\nJSON input: " + ((Object) h(input, i7)));
    }

    public static final A g(String key, String input) {
        kotlin.jvm.internal.r.f(key, "key");
        kotlin.jvm.internal.r.f(input, "input");
        return e(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) i(input, 0, 1, null)));
    }

    public static final CharSequence h(CharSequence charSequence, int i7) {
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i7 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i8 = i7 - 30;
        int i9 = i7 + 30;
        return (i8 <= 0 ? "" : ".....") + charSequence.subSequence(W5.l.b(i8, 0), W5.l.d(i9, charSequence.length())).toString() + (i9 >= charSequence.length() ? "" : ".....");
    }

    public static /* synthetic */ CharSequence i(CharSequence charSequence, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = -1;
        }
        return h(charSequence, i7);
    }

    public static final Void j(AbstractC2711a abstractC2711a, Number result) {
        kotlin.jvm.internal.r.f(abstractC2711a, "<this>");
        kotlin.jvm.internal.r.f(result, "result");
        AbstractC2711a.y(abstractC2711a, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new C0462g();
    }

    public static final String k(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) i(str2, 0, 1, null));
    }
}

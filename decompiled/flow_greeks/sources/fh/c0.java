package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {
    public static final y a(Number value, String key, String output) {
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(output, "output");
        return e(-1, m(value, key, output));
    }

    public static final a0 b(Number value, String output) {
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(output, "output");
        return new a0("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(output, 0, 1, null)));
    }

    public static final a0 c(Number value, String key, String output) {
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(output, "output");
        return new a0(m(value, key, output));
    }

    public static final a0 d(bh.e keyDescriptor) {
        kotlin.jvm.internal.t.f(keyDescriptor, "keyDescriptor");
        return new a0("Value of type '" + keyDescriptor.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.h() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final y e(int i10, String message) {
        kotlin.jvm.internal.t.f(message, "message");
        if (i10 >= 0) {
            message = "Unexpected JSON token at offset " + i10 + ": " + message;
        }
        return new y(message);
    }

    public static final y f(int i10, String message, CharSequence input) {
        kotlin.jvm.internal.t.f(message, "message");
        kotlin.jvm.internal.t.f(input, "input");
        return e(i10, message + "\nJSON input: " + ((Object) j(input, i10)));
    }

    public static final y g(String key, String input) {
        kotlin.jvm.internal.t.f(key, "key");
        kotlin.jvm.internal.t.f(input, "input");
        return e(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) k(input, 0, 1, null)));
    }

    public static final Void h(a aVar, String entity) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        kotlin.jvm.internal.t.f(entity, "entity");
        aVar.w("Trailing comma before the end of JSON " + entity, aVar.f9544a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new cd.h();
    }

    public static /* synthetic */ Void i(a aVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "object";
        }
        return h(aVar, str);
    }

    public static final CharSequence j(CharSequence charSequence, int i10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i10 != -1) {
                int i11 = i10 - 30;
                int i12 = i10 + 30;
                return (i11 <= 0 ? "" : ".....") + charSequence.subSequence(vd.l.b(i11, 0), vd.l.d(i12, charSequence.length())).toString() + (i12 >= charSequence.length() ? "" : ".....");
            }
            int length = charSequence.length() - 60;
            if (length > 0) {
                return "....." + charSequence.subSequence(length, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static /* synthetic */ CharSequence k(CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        return j(charSequence, i10);
    }

    public static final Void l(a aVar, Number result) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        kotlin.jvm.internal.t.f(result, "result");
        a.x(aVar, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new cd.h();
    }

    public static final String m(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(str2, 0, 1, null));
    }
}

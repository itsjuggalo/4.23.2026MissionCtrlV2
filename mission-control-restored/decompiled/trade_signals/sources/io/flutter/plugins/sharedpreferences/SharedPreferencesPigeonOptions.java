package io.flutter.plugins.sharedpreferences;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesPigeonOptions {
    public static final Companion Companion = new Companion(null);
    private final String fileName;
    private final boolean useDataStore;

    public static final class Companion {
        private Companion() {
        }

        public final SharedPreferencesPigeonOptions fromList(List<? extends Object> pigeonVar_list) {
            AbstractC2304t.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new SharedPreferencesPigeonOptions(str, ((Boolean) obj).booleanValue());
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public SharedPreferencesPigeonOptions(String str, boolean z7) {
        this.fileName = str;
        this.useDataStore = z7;
    }

    public static /* synthetic */ SharedPreferencesPigeonOptions copy$default(SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions, String str, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = sharedPreferencesPigeonOptions.fileName;
        }
        if ((i8 & 2) != 0) {
            z7 = sharedPreferencesPigeonOptions.useDataStore;
        }
        return sharedPreferencesPigeonOptions.copy(str, z7);
    }

    public final String component1() {
        return this.fileName;
    }

    public final boolean component2() {
        return this.useDataStore;
    }

    public final SharedPreferencesPigeonOptions copy(String str, boolean z7) {
        return new SharedPreferencesPigeonOptions(str, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharedPreferencesPigeonOptions)) {
            return false;
        }
        SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions = (SharedPreferencesPigeonOptions) obj;
        return AbstractC2304t.b(this.fileName, sharedPreferencesPigeonOptions.fileName) && this.useDataStore == sharedPreferencesPigeonOptions.useDataStore;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean getUseDataStore() {
        return this.useDataStore;
    }

    public int hashCode() {
        String str = this.fileName;
        return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.useDataStore);
    }

    public final List<Object> toList() {
        return AbstractC2595q.l(this.fileName, Boolean.valueOf(this.useDataStore));
    }

    public String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.fileName + ", useDataStore=" + this.useDataStore + ")";
    }

    public /* synthetic */ SharedPreferencesPigeonOptions(String str, boolean z7, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? null : str, z7);
    }
}

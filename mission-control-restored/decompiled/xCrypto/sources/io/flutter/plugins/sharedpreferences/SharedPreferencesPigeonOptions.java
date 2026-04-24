package io.flutter.plugins.sharedpreferences;

import X2.AbstractC0769p;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferencesPigeonOptions {
    public static final Companion Companion = new Companion(null);
    private final String fileName;
    private final boolean useDataStore;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final SharedPreferencesPigeonOptions fromList(List<? extends Object> pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            String str = (String) pigeonVar_list.get(0);
            Object obj = pigeonVar_list.get(1);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new SharedPreferencesPigeonOptions(str, ((Boolean) obj).booleanValue());
        }

        private Companion() {
        }
    }

    public SharedPreferencesPigeonOptions(String str, boolean z4) {
        this.fileName = str;
        this.useDataStore = z4;
    }

    public static /* synthetic */ SharedPreferencesPigeonOptions copy$default(SharedPreferencesPigeonOptions sharedPreferencesPigeonOptions, String str, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = sharedPreferencesPigeonOptions.fileName;
        }
        if ((i4 & 2) != 0) {
            z4 = sharedPreferencesPigeonOptions.useDataStore;
        }
        return sharedPreferencesPigeonOptions.copy(str, z4);
    }

    public final String component1() {
        return this.fileName;
    }

    public final boolean component2() {
        return this.useDataStore;
    }

    public final SharedPreferencesPigeonOptions copy(String str, boolean z4) {
        return new SharedPreferencesPigeonOptions(str, z4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SharedPreferencesPigeonOptions)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return MessagesAsyncPigeonUtils.INSTANCE.deepEquals(toList(), ((SharedPreferencesPigeonOptions) obj).toList());
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean getUseDataStore() {
        return this.useDataStore;
    }

    public int hashCode() {
        return toList().hashCode();
    }

    public final List<Object> toList() {
        return AbstractC0769p.j(this.fileName, Boolean.valueOf(this.useDataStore));
    }

    public String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.fileName + ", useDataStore=" + this.useDataStore + ")";
    }

    public /* synthetic */ SharedPreferencesPigeonOptions(String str, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : str, z4);
    }
}

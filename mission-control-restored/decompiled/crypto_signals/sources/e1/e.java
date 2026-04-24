package e1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f6053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e[] f6054d;

    static {
        e eVar = new e("NETWORK_UNMETERED", 0);
        f6051a = eVar;
        e eVar2 = new e("DEVICE_IDLE", 1);
        f6052b = eVar2;
        e eVar3 = new e("DEVICE_CHARGING", 2);
        f6053c = eVar3;
        f6054d = new e[]{eVar, eVar2, eVar3};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f6054d.clone();
    }
}

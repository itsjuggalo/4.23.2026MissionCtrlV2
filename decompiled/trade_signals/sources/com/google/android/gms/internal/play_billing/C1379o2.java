package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1379o2 implements InterfaceC1319c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1334f2 f15477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f15479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15480d;

    public C1379o2(InterfaceC1334f2 interfaceC1334f2, String str, Object[] objArr) {
        this.f15477a = interfaceC1334f2;
        this.f15478b = str;
        this.f15479c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f15480d = cCharAt;
            return;
        }
        int i8 = cCharAt & 8191;
        int i9 = 1;
        int i10 = 13;
        while (true) {
            int i11 = i9 + 1;
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 55296) {
                this.f15480d = i8 | (cCharAt2 << i10);
                return;
            } else {
                i8 |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i9 = i11;
            }
        }
    }

    public final String a() {
        return this.f15478b;
    }

    public final Object[] b() {
        return this.f15479c;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1319c2
    public final InterfaceC1334f2 zza() {
        return this.f15477a;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1319c2
    public final boolean zzb() {
        return (this.f15480d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1319c2
    public final int zzc() {
        int i8 = this.f15480d;
        if ((i8 & 1) != 0) {
            return 1;
        }
        return (i8 & 4) == 4 ? 3 : 2;
    }
}

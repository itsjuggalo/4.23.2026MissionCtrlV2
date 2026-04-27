package S1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: renamed from: S1.s4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0674s4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f4924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f4926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f4927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f4928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4929i;

    public RunnableC0674s4(C0540b5 c0540b5, String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        this.f4921a = str;
        this.f4922b = str2;
        this.f4923c = j4;
        this.f4924d = bundle;
        this.f4925e = z4;
        this.f4926f = z5;
        this.f4927g = z6;
        this.f4928h = str3;
        Objects.requireNonNull(c0540b5);
        this.f4929i = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4929i.v(this.f4921a, this.f4922b, this.f4923c, this.f4924d, this.f4925e, this.f4926f, this.f4927g, this.f4928h);
    }
}

package H3;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownTimer f3704a;

    public interface b {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f3704a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f3704a = null;
        }
    }

    public void b(b bVar, long j8, long j9) {
        this.f3704a = new a(j8, j9, bVar).start();
    }

    public class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f3705a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j8, long j9, b bVar) {
            super(j8, j9);
            this.f3705a = bVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f3705a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j8) {
        }
    }
}

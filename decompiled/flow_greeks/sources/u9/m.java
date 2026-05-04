package u9;

import android.os.CountDownTimer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownTimer f22470a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f22470a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f22470a = null;
        }
    }

    public void b(b bVar, long j10, long j11) {
        this.f22470a = new a(j10, j11, bVar).start();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f22471a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, b bVar) {
            super(j10, j11);
            this.f22471a = bVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f22471a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }
}

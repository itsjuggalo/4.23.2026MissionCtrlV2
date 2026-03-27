package okhttp3;

/* JADX INFO: loaded from: classes2.dex */
public interface Interceptor {

    public interface Chain {
        int a();

        int b();

        Response c(Request request);

        int d();

        Request e();
    }

    Response a(Chain chain);
}

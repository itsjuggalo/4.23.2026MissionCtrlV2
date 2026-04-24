package okhttp3;

/* JADX INFO: loaded from: classes2.dex */
public interface Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Authenticator f20238a = new Authenticator() { // from class: okhttp3.Authenticator.1
        @Override // okhttp3.Authenticator
        public Request a(Route route, Response response) {
            return null;
        }
    };

    Request a(Route route, Response response);
}

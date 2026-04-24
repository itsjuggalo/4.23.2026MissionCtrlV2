package okhttp3;

import java.util.ArrayList;
import java.util.UUID;
import u5.AbstractC1245b;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
public final class MultipartBody extends RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8792a = 0;

    public static final class Builder {
        public Builder() {
            String string = UUID.randomUUID().toString();
            int i = MultipartBody.f8792a;
            new ArrayList();
            j jVar = j.f10527d;
            AbstractC1245b.e(string);
        }
    }

    public static final class Part {
    }

    static {
        MediaType.a("multipart/mixed");
        MediaType.a("multipart/alternative");
        MediaType.a("multipart/digest");
        MediaType.a("multipart/parallel");
        MediaType.a("multipart/form-data");
    }
}

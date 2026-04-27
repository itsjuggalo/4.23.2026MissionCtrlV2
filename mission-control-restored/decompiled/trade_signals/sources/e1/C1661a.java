package e1;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: e1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1661a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f17138a;

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    public static class C0291a implements e.a {
        @Override // com.bumptech.glide.load.data.e.a
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e b(ByteBuffer byteBuffer) {
            return new C1661a(byteBuffer);
        }
    }

    public C1661a(ByteBuffer byteBuffer) {
        this.f17138a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f17138a.position(0);
        return this.f17138a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }
}

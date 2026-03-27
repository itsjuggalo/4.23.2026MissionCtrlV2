package X4;

import U4.m;
import android.view.PointerIcon;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap f5494c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f5496b;

    /* JADX INFO: renamed from: X4.a$a, reason: collision with other inner class name */
    public class C0099a implements m.b {
        public C0099a() {
        }

        @Override // U4.m.b
        public void a(String str) {
            a.this.f5495a.setPointerIcon(a.this.d(str));
        }
    }

    public class b extends HashMap {
        public b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    public interface c {
        PointerIcon a(int i7);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public a(c cVar, m mVar) {
        this.f5495a = cVar;
        this.f5496b = mVar;
        mVar.b(new C0099a());
    }

    public void c() {
        this.f5496b.b(null);
    }

    public final PointerIcon d(String str) {
        if (f5494c == null) {
            f5494c = new b();
        }
        return this.f5495a.a(((Integer) f5494c.getOrDefault(str, 1000)).intValue());
    }
}

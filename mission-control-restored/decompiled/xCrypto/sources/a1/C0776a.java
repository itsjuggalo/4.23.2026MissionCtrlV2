package a1;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import d1.C1210a;
import d1.C1211b;
import d1.C1212c;
import d1.C1213d;
import d1.C1214e;
import d1.C1215f;
import io.flutter.plugins.firebase.crashlytics.Constants;

/* JADX INFO: renamed from: a1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0776a implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Configurator f6019a = new C0776a();

    /* JADX INFO: renamed from: a1.a$a, reason: collision with other inner class name */
    public static final class C0084a implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0084a f6020a = new C0084a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6021b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f6022c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FieldDescriptor f6023d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final FieldDescriptor f6024e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1210a c1210a, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6021b, c1210a.d());
            objectEncoderContext.add(f6022c, c1210a.c());
            objectEncoderContext.add(f6023d, c1210a.b());
            objectEncoderContext.add(f6024e, c1210a.a());
        }
    }

    /* JADX INFO: renamed from: a1.a$b */
    public static final class b implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6025a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6026b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1211b c1211b, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6026b, c1211b.a());
        }
    }

    /* JADX INFO: renamed from: a1.a$c */
    public static final class c implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6027a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6028b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f6029c = FieldDescriptor.builder(Constants.REASON).withProperty(AtProtobuf.builder().tag(3).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1212c c1212c, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6028b, c1212c.a());
            objectEncoderContext.add(f6029c, c1212c.b());
        }
    }

    /* JADX INFO: renamed from: a1.a$d */
    public static final class d implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6030a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6031b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f6032c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1213d c1213d, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6031b, c1213d.b());
            objectEncoderContext.add(f6032c, c1213d.a());
        }
    }

    /* JADX INFO: renamed from: a1.a$e */
    public static final class e implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6033a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6034b = FieldDescriptor.of("clientMetrics");

        public void a(m mVar, ObjectEncoderContext objectEncoderContext) {
            throw null;
        }

        @Override // com.google.firebase.encoders.Encoder
        public /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            android.support.v4.media.session.b.a(obj);
            a(null, objectEncoderContext);
        }
    }

    /* JADX INFO: renamed from: a1.a$f */
    public static final class f implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6035a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6036b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f6037c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1214e c1214e, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6036b, c1214e.a());
            objectEncoderContext.add(f6037c, c1214e.b());
        }
    }

    /* JADX INFO: renamed from: a1.a$g */
    public static final class g implements ObjectEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6038a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FieldDescriptor f6039b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final FieldDescriptor f6040c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        @Override // com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(C1215f c1215f, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6039b, c1215f.b());
            objectEncoderContext.add(f6040c, c1215f.a());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(m.class, e.f6033a);
        encoderConfig.registerEncoder(C1210a.class, C0084a.f6020a);
        encoderConfig.registerEncoder(C1215f.class, g.f6038a);
        encoderConfig.registerEncoder(C1213d.class, d.f6030a);
        encoderConfig.registerEncoder(C1212c.class, c.f6027a);
        encoderConfig.registerEncoder(C1211b.class, b.f6025a);
        encoderConfig.registerEncoder(C1214e.class, f.f6035a);
    }
}

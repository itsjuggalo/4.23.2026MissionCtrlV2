package b0;

import P3.u;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0374c extends MediaCodec.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0376e f4817b;

    public C0374c(C0376e c0376e) {
        this.f4817b = c0376e;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        C0376e c0376e = this.f4817b;
        if (mediaCodec != c0376e.f4829a) {
            return;
        }
        Log.e("HeifEncoder", "onError: " + codecException);
        c0376e.j();
        u uVar = c0376e.f4830b;
        if (codecException == null) {
            uVar.i(null);
        } else {
            uVar.i(codecException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        C0376e c0376e = this.f4817b;
        if (mediaCodec != c0376e.f4829a || c0376e.f4841r) {
            return;
        }
        c0376e.f4847x.add(Integer.valueOf(i));
        c0376e.h();
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        if (mediaCodec != this.f4817b.f4829a || this.f4816a) {
            return;
        }
        if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i);
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            C0375d c0375d = this.f4817b.y;
            if (c0375d != null) {
                long j4 = bufferInfo.presentationTimeUs;
                synchronized (c0375d) {
                    c0375d.f4822f = j4;
                    c0375d.a();
                }
            }
            u uVar = this.f4817b.f4830b;
            if (!uVar.f2601b) {
                C0377f c0377f = (C0377f) uVar.f2602c;
                if (c0377f.f4856m == null) {
                    uVar.i(new IllegalStateException("Output buffer received before format info"));
                } else {
                    if (c0377f.f4857n < c0377f.f4852d * c0377f.f4851c) {
                        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                        bufferInfo2.set(outputBuffer.position(), outputBuffer.remaining(), 0L, 0);
                        c0377f.f4853f.writeSampleData(c0377f.f4856m[c0377f.f4857n / c0377f.f4851c], outputBuffer, bufferInfo2);
                    }
                    int i6 = c0377f.f4857n + 1;
                    c0377f.f4857n = i6;
                    if (i6 == c0377f.f4852d * c0377f.f4851c) {
                        uVar.i(null);
                    }
                }
            }
        }
        this.f4816a |= (bufferInfo.flags & 4) != 0;
        mediaCodec.releaseOutputBuffer(i, false);
        if (this.f4816a) {
            C0376e c0376e = this.f4817b;
            c0376e.j();
            c0376e.f4830b.i(null);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        C0376e c0376e = this.f4817b;
        if (mediaCodec != c0376e.f4829a) {
            return;
        }
        if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
            mediaFormat.setString("mime", "image/vnd.android.heic");
            mediaFormat.setInteger("width", c0376e.e);
            mediaFormat.setInteger("height", c0376e.f4833f);
            if (c0376e.f4839p) {
                mediaFormat.setInteger("tile-width", c0376e.f4834k);
                mediaFormat.setInteger("tile-height", c0376e.f4835l);
                mediaFormat.setInteger("grid-rows", c0376e.f4836m);
                mediaFormat.setInteger("grid-cols", c0376e.f4837n);
            }
        }
        u uVar = c0376e.f4830b;
        if (uVar.f2601b) {
            return;
        }
        C0377f c0377f = (C0377f) uVar.f2602c;
        if (c0377f.f4856m != null) {
            uVar.i(new IllegalStateException("Output format changed after muxer started"));
            return;
        }
        try {
            c0377f.f4851c = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
        } catch (ClassCastException | NullPointerException unused) {
            c0377f.f4851c = 1;
        }
        c0377f.f4856m = new int[c0377f.f4852d];
        int i = 0;
        while (i < c0377f.f4856m.length) {
            mediaFormat.setInteger("is-default", i == 0 ? 1 : 0);
            c0377f.f4856m[i] = c0377f.f4853f.addTrack(mediaFormat);
            i++;
        }
        c0377f.f4853f.start();
        c0377f.f4855l.set(true);
        c0377f.f();
    }
}

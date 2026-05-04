.class public Lh4/j;
.super Lh4/e;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public constructor <init>(Lh4/i;Lh4/d;J)V
    .locals 5

    .line 1
    invoke-direct {p0}, Lh4/e;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x4

    .line 5
    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget-boolean v1, p2, Lh4/d;->a:Z

    .line 10
    .line 11
    if-eqz v1, :cond_0

    .line 12
    .line 13
    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    .line 17
    .line 18
    :goto_0
    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 19
    .line 20
    .line 21
    iget-wide v1, p2, Lh4/d;->c:J

    .line 22
    .line 23
    iget p2, p2, Lh4/d;->e:I

    .line 24
    .line 25
    int-to-long v3, p2

    .line 26
    mul-long/2addr p3, v3

    .line 27
    add-long/2addr v1, p3

    .line 28
    invoke-virtual {p1, v0, v1, v2}, Lh4/i;->H(Ljava/nio/ByteBuffer;J)J

    .line 29
    .line 30
    .line 31
    move-result-wide p2

    .line 32
    iput-wide p2, p0, Lh4/e;->a:J

    .line 33
    .line 34
    const-wide/16 p2, 0x4

    .line 35
    .line 36
    add-long/2addr p2, v1

    .line 37
    invoke-virtual {p1, v0, p2, p3}, Lh4/i;->H(Ljava/nio/ByteBuffer;J)J

    .line 38
    .line 39
    .line 40
    move-result-wide p2

    .line 41
    iput-wide p2, p0, Lh4/e;->b:J

    .line 42
    .line 43
    const-wide/16 p2, 0x8

    .line 44
    .line 45
    add-long/2addr p2, v1

    .line 46
    invoke-virtual {p1, v0, p2, p3}, Lh4/i;->H(Ljava/nio/ByteBuffer;J)J

    .line 47
    .line 48
    .line 49
    move-result-wide p2

    .line 50
    iput-wide p2, p0, Lh4/e;->c:J

    .line 51
    .line 52
    const-wide/16 p2, 0x14

    .line 53
    .line 54
    add-long/2addr v1, p2

    .line 55
    invoke-virtual {p1, v0, v1, v2}, Lh4/i;->H(Ljava/nio/ByteBuffer;J)J

    .line 56
    .line 57
    .line 58
    move-result-wide p1

    .line 59
    iput-wide p1, p0, Lh4/e;->d:J

    .line 60
    .line 61
    return-void
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method

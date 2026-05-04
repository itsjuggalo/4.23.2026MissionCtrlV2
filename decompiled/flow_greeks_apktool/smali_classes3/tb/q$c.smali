.class public Ltb/q$c;
.super Ltb/y;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/q;->G(Lrb/g$a;Lrb/y0;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "c"
.end annotation


# instance fields
.field public final synthetic b:Lrb/g$a;

.field public final synthetic c:Ljava/lang/String;

.field public final synthetic d:Ltb/q;


# direct methods
.method public constructor <init>(Ltb/q;Lrb/g$a;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/q$c;->d:Ltb/q;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/q$c;->b:Lrb/g$a;

    .line 4
    .line 5
    iput-object p3, p0, Ltb/q$c;->c:Ljava/lang/String;

    .line 6
    .line 7
    invoke-static {p1}, Ltb/q;->m(Ltb/q;)Lrb/r;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    invoke-direct {p0, p1}, Ltb/y;-><init>(Lrb/r;)V

    .line 12
    .line 13
    .line 14
    return-void
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
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
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
.end method


# virtual methods
.method public a()V
    .locals 5

    .line 1
    iget-object v0, p0, Ltb/q$c;->d:Ltb/q;

    .line 2
    .line 3
    iget-object v1, p0, Ltb/q$c;->b:Lrb/g$a;

    .line 4
    .line 5
    sget-object v2, Lrb/k1;->s:Lrb/k1;

    .line 6
    .line 7
    iget-object v3, p0, Ltb/q$c;->c:Ljava/lang/String;

    .line 8
    .line 9
    filled-new-array {v3}, [Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object v3

    .line 13
    const-string v4, "Unable to find compressor by name %s"

    .line 14
    .line 15
    invoke-static {v4, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 16
    .line 17
    .line 18
    move-result-object v3

    .line 19
    invoke-virtual {v2, v3}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 20
    .line 21
    .line 22
    move-result-object v2

    .line 23
    new-instance v3, Lrb/y0;

    .line 24
    .line 25
    invoke-direct {v3}, Lrb/y0;-><init>()V

    .line 26
    .line 27
    .line 28
    invoke-static {v0, v1, v2, v3}, Ltb/q;->n(Ltb/q;Lrb/g$a;Lrb/k1;Lrb/y0;)V

    .line 29
    .line 30
    .line 31
    return-void
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
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
.end method

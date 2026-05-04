.class public Lj8/t$a;
.super Lr8/c$c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lj8/t;->h(Lr8/n;Lj8/f0;Ljava/util/Map;)Lr8/n;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lj8/f0;

.field public final synthetic b:Ljava/util/Map;

.field public final synthetic c:Lj8/u;


# direct methods
.method public constructor <init>(Lj8/f0;Ljava/util/Map;Lj8/u;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lj8/t$a;->a:Lj8/f0;

    .line 2
    .line 3
    iput-object p2, p0, Lj8/t$a;->b:Ljava/util/Map;

    .line 4
    .line 5
    iput-object p3, p0, Lj8/t$a;->c:Lj8/u;

    .line 6
    .line 7
    invoke-direct {p0}, Lr8/c$c;-><init>()V

    .line 8
    .line 9
    .line 10
    return-void
    .line 11
    .line 12
    .line 13
    .line 14
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
.end method


# virtual methods
.method public b(Lr8/b;Lr8/n;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lj8/t$a;->a:Lj8/f0;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lj8/f0;->a(Lr8/b;)Lj8/f0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Lj8/t$a;->b:Ljava/util/Map;

    .line 8
    .line 9
    invoke-static {p2, v0, v1}, Lj8/t;->a(Lr8/n;Lj8/f0;Ljava/util/Map;)Lr8/n;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    if-eq v0, p2, :cond_0

    .line 14
    .line 15
    iget-object p2, p0, Lj8/t$a;->c:Lj8/u;

    .line 16
    .line 17
    new-instance v1, Lj8/l;

    .line 18
    .line 19
    invoke-virtual {p1}, Lr8/b;->b()Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    invoke-direct {v1, p1}, Lj8/l;-><init>(Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    invoke-virtual {p2, v1, v0}, Lj8/u;->c(Lj8/l;Lr8/n;)V

    .line 27
    .line 28
    .line 29
    :cond_0
    return-void
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
.end method

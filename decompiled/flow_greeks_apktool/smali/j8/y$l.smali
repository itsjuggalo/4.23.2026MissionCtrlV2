.class public Lj8/y$l;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lj8/y;->z(Lj8/l;Ljava/util/Map;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ljava/util/Map;

.field public final synthetic b:Lj8/l;

.field public final synthetic c:Lj8/y;


# direct methods
.method public constructor <init>(Lj8/y;Ljava/util/Map;Lj8/l;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lj8/y$l;->c:Lj8/y;

    .line 2
    .line 3
    iput-object p2, p0, Lj8/y$l;->a:Ljava/util/Map;

    .line 4
    .line 5
    iput-object p3, p0, Lj8/y$l;->b:Lj8/l;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
.method public a()Ljava/util/List;
    .locals 5

    .line 1
    iget-object v0, p0, Lj8/y$l;->a:Ljava/util/Map;

    .line 2
    .line 3
    invoke-static {v0}, Lj8/b;->r(Ljava/util/Map;)Lj8/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Lj8/y$l;->c:Lj8/y;

    .line 8
    .line 9
    invoke-static {v1}, Lj8/y;->c(Lj8/y;)Ll8/e;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    iget-object v2, p0, Lj8/y$l;->b:Lj8/l;

    .line 14
    .line 15
    invoke-interface {v1, v2, v0}, Ll8/e;->g(Lj8/l;Lj8/b;)V

    .line 16
    .line 17
    .line 18
    iget-object v1, p0, Lj8/y$l;->c:Lj8/y;

    .line 19
    .line 20
    new-instance v2, Lk8/c;

    .line 21
    .line 22
    sget-object v3, Lk8/e;->e:Lk8/e;

    .line 23
    .line 24
    iget-object v4, p0, Lj8/y$l;->b:Lj8/l;

    .line 25
    .line 26
    invoke-direct {v2, v3, v4, v0}, Lk8/c;-><init>(Lk8/e;Lj8/l;Lj8/b;)V

    .line 27
    .line 28
    .line 29
    invoke-static {v1, v2}, Lj8/y;->k(Lj8/y;Lk8/d;)Ljava/util/List;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    return-object v0
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
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lj8/y$l;->a()Ljava/util/List;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

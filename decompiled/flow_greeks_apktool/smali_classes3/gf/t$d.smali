.class public Lgf/t$d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lgf/d$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lgf/t;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "d"
.end annotation


# instance fields
.field public final a:Lgf/t$c;

.field public b:Lgf/d$a;

.field public c:I

.field public final synthetic d:Lgf/t;


# direct methods
.method public constructor <init>(Lgf/t;)V
    .locals 2

    .line 2
    iput-object p1, p0, Lgf/t$d;->d:Lgf/t;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    new-instance v0, Lgf/t$c;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lgf/t$c;-><init>(Lgf/d;Lgf/t$a;)V

    iput-object v0, p0, Lgf/t$d;->a:Lgf/t$c;

    .line 4
    invoke-virtual {v0}, Lgf/t$c;->d()Lgf/o;

    move-result-object v0

    invoke-virtual {v0}, Lgf/o;->W()Lgf/d$a;

    move-result-object v0

    iput-object v0, p0, Lgf/t$d;->b:Lgf/d$a;

    .line 5
    invoke-virtual {p1}, Lgf/t;->size()I

    move-result p1

    iput p1, p0, Lgf/t$d;->c:I

    return-void
.end method

.method public synthetic constructor <init>(Lgf/t;Lgf/t$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lgf/t$d;-><init>(Lgf/t;)V

    return-void
.end method


# virtual methods
.method public a()B
    .locals 1

    .line 1
    iget-object v0, p0, Lgf/t$d;->b:Lgf/d$a;

    .line 2
    .line 3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Lgf/t$d;->a:Lgf/t$c;

    .line 10
    .line 11
    invoke-virtual {v0}, Lgf/t$c;->d()Lgf/o;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    invoke-virtual {v0}, Lgf/o;->W()Lgf/d$a;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    iput-object v0, p0, Lgf/t$d;->b:Lgf/d$a;

    .line 20
    .line 21
    :cond_0
    iget v0, p0, Lgf/t$d;->c:I

    .line 22
    .line 23
    add-int/lit8 v0, v0, -0x1

    .line 24
    .line 25
    iput v0, p0, Lgf/t$d;->c:I

    .line 26
    .line 27
    iget-object v0, p0, Lgf/t$d;->b:Lgf/d$a;

    .line 28
    .line 29
    invoke-interface {v0}, Lgf/d$a;->a()B

    .line 30
    .line 31
    .line 32
    move-result v0

    .line 33
    return v0
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

.method public b()Ljava/lang/Byte;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lgf/t$d;->a()B

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public hasNext()Z
    .locals 1

    .line 1
    iget v0, p0, Lgf/t$d;->c:I

    .line 2
    .line 3
    if-lez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x1

    .line 6
    return v0

    .line 7
    :cond_0
    const/4 v0, 0x0

    .line 8
    return v0
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lgf/t$d;->b()Ljava/lang/Byte;

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
    .line 17
    .line 18
    .line 19
.end method

.method public remove()V
    .locals 1

    .line 1
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    .line 4
    .line 5
    .line 6
    throw v0
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
    .line 17
    .line 18
    .line 19
.end method

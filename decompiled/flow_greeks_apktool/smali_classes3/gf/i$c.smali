.class public abstract Lgf/i$c;
.super Lgf/i$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lgf/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lgf/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "c"
.end annotation


# instance fields
.field public b:Lgf/h;

.field public c:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lgf/i$b;-><init>()V

    .line 2
    .line 3
    .line 4
    invoke-static {}, Lgf/h;->g()Lgf/h;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    iput-object v0, p0, Lgf/i$c;->b:Lgf/h;

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
.end method

.method public static synthetic l(Lgf/i$c;)Lgf/h;
    .locals 0

    .line 1
    invoke-virtual {p0}, Lgf/i$c;->m()Lgf/h;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public final m()Lgf/h;
    .locals 1

    .line 1
    iget-object v0, p0, Lgf/i$c;->b:Lgf/h;

    .line 2
    .line 3
    invoke-virtual {v0}, Lgf/h;->q()V

    .line 4
    .line 5
    .line 6
    const/4 v0, 0x0

    .line 7
    iput-boolean v0, p0, Lgf/i$c;->c:Z

    .line 8
    .line 9
    iget-object v0, p0, Lgf/i$c;->b:Lgf/h;

    .line 10
    .line 11
    return-object v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public final n()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lgf/i$c;->c:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Lgf/i$c;->b:Lgf/h;

    .line 6
    .line 7
    invoke-virtual {v0}, Lgf/h;->b()Lgf/h;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    iput-object v0, p0, Lgf/i$c;->b:Lgf/h;

    .line 12
    .line 13
    const/4 v0, 0x1

    .line 14
    iput-boolean v0, p0, Lgf/i$c;->c:Z

    .line 15
    .line 16
    :cond_0
    return-void
    .line 17
    .line 18
    .line 19
.end method

.method public final o(Lgf/i$d;)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lgf/i$c;->n()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lgf/i$c;->b:Lgf/h;

    .line 5
    .line 6
    invoke-static {p1}, Lgf/i$d;->q(Lgf/i$d;)Lgf/h;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    invoke-virtual {v0, p1}, Lgf/h;->r(Lgf/h;)V

    .line 11
    .line 12
    .line 13
    return-void
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
.end method

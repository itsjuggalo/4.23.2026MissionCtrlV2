.class public final Lng/w2;
.super Ljava/util/concurrent/CancellationException;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final transient a:Lng/y1;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    const/4 v0, 0x0

    .line 3
    invoke-direct {p0, p1, v0}, Lng/w2;-><init>(Ljava/lang/String;Lng/y1;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lng/y1;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Ljava/util/concurrent/CancellationException;-><init>(Ljava/lang/String;)V

    .line 2
    iput-object p2, p0, Lng/w2;->a:Lng/y1;

    return-void
.end method

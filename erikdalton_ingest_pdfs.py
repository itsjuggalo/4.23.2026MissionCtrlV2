#!/usr/bin/env python3
"""
Ingest Erik Dalton / Massage Desktop PDFs into ~/erikdalton-kb/transcripts/pdfs/.
Uses pdftotext for extraction; falls back to pypdf for encrypted/unusual PDFs.
Run once; resume-safe (skips already-extracted files).
"""
import os, re, subprocess, time
from pathlib import Path

HOME = Path.home()
PDF_SOURCES = [
    Path("/mnt/c/Users/itsju/OneDrive/Desktop/Erik Dalton DVDs"),
    Path("/mnt/c/Users/itsju/OneDrive/Desktop/Massage"),
]
OUT_DIR = HOME / "erikdalton-kb" / "transcripts" / "pdfs"
OUT_DIR.mkdir(parents=True, exist_ok=True)
TODAY = time.strftime("%Y-%m-%d")

# PDFs to skip (not bodywork/MAT content)
SKIP_PATTERNS = re.compile(
    r'blank_llc|massage_llc|massage_est|website|logo|Human_Trafficking|Achievement|'
    r'tryout|masssage_website|foil|unemployment|warranty|download\.pdf',
    re.IGNORECASE
)


def safe_stem(path: Path) -> str:
    return re.sub(r'[^\w]', '_', path.stem).strip('_')[:100]


def extract_text_pdftotext(pdf_path: Path) -> str:
    try:
        result = subprocess.run(
            ["/usr/bin/pdftotext", "-q", str(pdf_path), "-"],
            capture_output=True, timeout=60
        )
        text = result.stdout.decode("utf-8", errors="replace").strip()
        return text
    except Exception:
        return ""


def extract_text_pypdf(pdf_path: Path) -> str:
    try:
        import pypdf
        reader = pypdf.PdfReader(str(pdf_path))
        pages = []
        for page in reader.pages:
            t = page.extract_text()
            if t:
                pages.append(t.strip())
        return "\n\n".join(pages)
    except Exception:
        return ""


def ingest_pdf(pdf_path: Path) -> bool:
    stem = safe_stem(pdf_path)
    out_path = OUT_DIR / f"{stem}.md"
    if out_path.exists():
        return True  # already done

    # Determine course from parent folder structure
    for base in PDF_SOURCES:
        try:
            rel = pdf_path.relative_to(base)
            parts = rel.parts
            if len(parts) >= 2:
                course = f"{parts[0]} — {parts[1]}" if len(parts) >= 3 else parts[0]
            else:
                course = "Erik Dalton — Reference Materials"
            break
        except ValueError:
            course = "Erik Dalton — Reference Materials"

    # Extract text
    text = extract_text_pdftotext(pdf_path)
    if len(text) < 100:
        text = extract_text_pypdf(pdf_path)
    if len(text) < 50:
        print(f"  SKIP (no text): {pdf_path.name}")
        return False

    # Write markdown
    title = pdf_path.stem.replace("_", " ").replace("-", " ")
    md = (
        f"---\n"
        f"source: erikdalton-pdf\n"
        f"course: \"{course}\"\n"
        f"title: \"{title}\"\n"
        f"filename: \"{pdf_path.name}\"\n"
        f"ingested: \"{TODAY}\"\n"
        f"---\n\n"
        f"## {title}\n\n"
        f"*Course: {course}*\n\n"
        f"{text}\n"
    )
    out_path.write_text(md, encoding="utf-8", errors="replace")
    print(f"  OK: {pdf_path.name} → {len(text)} chars")
    return True


def main():
    pdfs = []
    for base in PDF_SOURCES:
        pdfs.extend(base.rglob("*.pdf"))
        pdfs.extend(base.rglob("*.PDF"))

    # Filter irrelevant files
    pdfs = [p for p in sorted(pdfs) if not SKIP_PATTERNS.search(p.name)]
    print(f"Found {len(pdfs)} relevant PDFs to ingest")

    done = already = 0
    for pdf in pdfs:
        stem = safe_stem(pdf)
        if (OUT_DIR / f"{stem}.md").exists():
            already += 1
            continue
        if ingest_pdf(pdf):
            done += 1
        else:
            pass

    print(f"\nDone: {done} new, {already} already existed, {len(pdfs)} total")


if __name__ == "__main__":
    main()

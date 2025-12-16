// --- 1. กำหนดตัวแปรหลัก ---
const slider = document.getElementById('heroSlider');
const carouselInner = slider.querySelector('.carousel-inner');
const items = slider.querySelectorAll('.carousel-item');
const dotsContainer = document.getElementById('carouselDots');
const dots = dotsContainer.querySelectorAll('.dot');

let currentIndex = 0;
const totalItems = items.length;

// --- 2. ฟังก์ชันหลักสำหรับเปลี่ยนสไลด์ ---
function goToSlide(index) {
    if (index < 0) {
        // วนกลับไปสไลด์สุดท้าย
        currentIndex = totalItems - 1;
    } else if (index >= totalItems) {
        // วนกลับไปสไลด์แรก
        currentIndex = 0;
    } else {
        currentIndex = index;
    }

    // A. อัปเดต Class Active สำหรับสไลด์
    items.forEach((item, i) => {
        item.classList.remove('active');
        if (i === currentIndex) {
            item.classList.add('active');
        }
    });

    // B. อัปเดต Class Active สำหรับจุดวงกลม (Dots)
    dots.forEach((dot, i) => {
        dot.classList.remove('active');
        if (i === currentIndex) {
            dot.classList.add('active');
        }
    });

    // C. (ทางเลือก) อัปเดตภาพพื้นหลัง/ภาพนางแบบ ถ้าเราใช้ CSS จัดการ
    // ในโค้ดตัวอย่างนี้ เราจัดการด้วยการซ่อน/แสดง .carousel-item ด้วย CSS
    // แต่ถ้าใช้แบบนี้ คุณอาจต้องอัปเดต H1/P/Button ด้วย JS ถ้าเนื้อหาแต่ละสไลด์ต่างกัน
}

// --- 3. การควบคุม: เมื่อคลิกที่จุดวงกลม ---
dotsContainer.addEventListener('click', (event) => {
    const clickedDot = event.target.closest('.dot');
    if (clickedDot) {
        // ดึงค่า data-slide-to (ตำแหน่งสไลด์)
        const slideIndex = parseInt(clickedDot.getAttribute('data-slide-to'));
        goToSlide(slideIndex);
        // รีเซ็ตตัวนับอัตโนมัติ (ถ้ามี)
        // clearInterval(autoSlideInterval); 
        // startAutoSlide(); 
    }
});

// --- 4. การทำงานอัตโนมัติ (Optional) ---
/*
function nextSlide() {
    goToSlide(currentIndex + 1);
}

// กำหนดให้เปลี่ยนสไลด์ทุก 5 วินาที
const autoSlideInterval = setInterval(nextSlide, 5000); 

function startAutoSlide() {
    autoSlideInterval = setInterval(nextSlide, 5000); 
}
*/
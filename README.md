<div align="center">

# Clinify: Medical Appointment Management System

</div>

## 📋 Overview

**Clinify** is a frontend-only web application developed as a class project for **CP317 (Software Engineering)** at Wilfrid Laurier University. It simulates a centralized appointment management interface for a medical clinic, serving four distinct user roles: patients, doctors, receptionists, and system administrators.

> ⚠️ **Note:** This is a frontend-only project. There is no backend, live database, or server-side logic. All data is handled client-side using mock/static data.

---

## 🚨 The Problem

Manual clinic scheduling leads to:
- 📅 Double bookings from uncoordinated availability
- ⏳ Long wait times and poor time management
- 📞 Excessive back-and-forth communication between staff and patients
- ❌ Missed or forgotten appointments

---

## ✅ What Clinify Does

Clinify provides a clean, role-based UI that demonstrates how a real clinic management system would work, allowing each user type to interact with the system according to their responsibilities.

---

## 👥 User Roles & Views

| Role | What They Can Do |
|------|-----------------|
| 🧑‍⚕️ **Patient** | Book, reschedule, and cancel appointments |
| 🖥️ **Receptionist** | Schedule appointments on behalf of patients; manage clinic calendar |
| 👨‍⚕️ **Doctor** | Manage availability; view schedule; update appointment and patient record statuses |
| 🔧 **Administrator** | Manage user accounts; configure system settings; view reports |

---

## 🖥️ Features (Frontend)

- **Role-based dashboards** — each user type gets a tailored view and navigation
- **Appointment booking flow** — time slot selection, conflict display, and confirmation screens
- **Clinic calendar view** — visual schedule for doctors and receptionists
- **Patient record viewer** — read/update interface for doctor use
- **Admin panel** — user management and settings UI
- **Notifications UI** — appointment reminders and status update alerts
- **Responsive design** — works across desktop and mobile screen sizes

---

## 🔄 Appointment Flow (UI)

```
Patient Selects Time Slot
         │
         ▼
  Conflict Check Display
         │
    ┌────┴────┐
    │         │
 Conflict   Available
    │         │
 Show Error   ▼
         Confirmation Screen
              │
         ┌────┴───────────────┐
         │                    │
    Auto-Confirmed       Pending Review
    (shown to patient)   (shown to receptionist)
```

---

## 🚫 Out of Scope

The following are **not implemented** in this project:

- 🔌 Backend / server-side logic or real database
- 🎥 Real-time video or messaging between users
- 💳 Payment or billing functionality
- 🔐 Real authentication or user session management
- 🏥 Multi-clinic or hospital integration

---

### Installation

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/clinify.git

# Navigate into the project
cd clinify

# Install dependencies
npm install

# Start the development server
npm run dev
```

Then open [http://localhost:5173](http://localhost:5173) in your browser.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| HTML / CSS / JavaScript | Core frontend |
| React | Component-based UI |
| React Router | Client-side routing between role views |
| Mock Data (JSON) | Simulated appointments and user records |

---

## 👨‍💻 Team

> CP317 — Software Engineering | Wilfrid Laurier University

| Name | Role |
|------|------|
| *(Add team members here)* | *(Add roles here)* |

---

<div align="center">
  <sub>Built for CP317 · Wilfrid Laurier University</sub>
</div>

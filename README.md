<div align="center">

# Clinify: Medical Appointment Management System

**CP317 | Wilfrid Laurier University**

</div>

## Overview

Clinify is a web-based medical appointment management system built for CP317 at Wilfrid Laurier University. It supports four user roles: patients, doctors, receptionists, and administrators.

## The Problem

Manual clinic scheduling causes double bookings, long wait times, too much back and forth between staff and patients, and missed appointments.

## User Roles

| Role | What They Can Do |
|------|-----------------|
| Patient | Book, reschedule, and cancel appointments |
| Receptionist | Schedule appointments on behalf of patients and manage the clinic calendar |
| Doctor | Manage availability, view schedule, and update appointment statuses |
| Administrator | Manage user accounts, configure settings, and view reports |

## Features

- Role-based dashboards for each user type
- Appointment booking with conflict detection and confirmation
- Clinic calendar view for doctors and receptionists
- Patient record viewer for doctors
- Admin panel for user management
- Notification alerts for appointment updates
- Responsive design for desktop and mobile

## Appointment Flow

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

## Running Locally

Clinify is a frontend-only project with no build tools or frameworks needed. Just clone the repo and use one of the options below.

**Do not open index.html by double-clicking it.** Browser security restrictions will break the app when opened as a file. Use a local server instead.

### Option 1: VS Code Live Server (Recommended)

1. Install [Visual Studio Code](https://code.visualstudio.com/)
2. Install the **Live Server** extension by Ritwick Dey
3. Clone the repo:
   ```bash
   git clone https://github.com/Sarim78/Clinify.git
   cd Clinify
   ```
4. Open the folder in VS Code
5. Right-click `index.html` and choose **Open with Live Server**
6. The app opens at `http://127.0.0.1:5500/index.html`

### Option 2: Python

1. Clone the repo:
   ```bash
   git clone https://github.com/Sarim78/Clinify.git
   cd Clinify
   ```
2. Run a local server:
   ```bash
   python -m http.server 8000
   ```
3. Open `http://localhost:8000/index.html` in your browser

### Option 3: Node.js

1. Clone the repo:
   ```bash
   git clone https://github.com/Sarim78/Clinify.git
   cd Clinify
   ```
2. Run:
   ```bash
   npx serve .
   ```
3. Open `http://localhost:3000/index.html` in your browser

## Project Structure

```
Clinify/
├── index.html          # Main entry point, open this to start the app
├── Login.html          # Login and role selection
├── patient/            # Patient dashboard views
├── doctor/             # Doctor dashboard views
├── receptionist/       # Receptionist dashboard views
├── admin/              # Admin dashboard views
└── assets/             # CSS, JS, images
```

## Team

| Name | Role |
|------|------|
| Sarim Siddiqui | Developer |
| James Coulson | Developer |
| Ebrahim Ghani | Developer |
| Jiale Zhang | Developer |
| Umair Waraich | Developer |
| Zayan Syeed | Developer |
| Niranjan Prabu | Developer |
| Lado logga | Developer |
| Joshua Ehikhuemen | Developer |

<div align="center">
  <sub>Built for CP317 · Wilfrid Laurier University</sub>
</div>

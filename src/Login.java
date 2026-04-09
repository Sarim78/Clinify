public boolean login(String inputEmail, String inputPassword) {

    User dbUser = Database.findUserByEmail(inputEmail);

    if (dbUser == null)
    {
        System.out.println("Invalid email. User does not exist.");
        return false;
    }
    else
    {
        if (dbUser.password.equals(inputPassword))
        {
            SystemSession.setCurrentUser(dbUser.userID);
            SystemSession.setUserRole(dbUser.role);

            if (dbUser.role.equals("Doctor"))
            {
                UserInterface.loadDoctorDashboard();
            }
            else if (dbUser.role.equals("Patient"))
            {
                UserInterface.loadPatientDashboard();
            }
            else if (dbUser.role.equals("Receptionist"))
            {
                UserInterface.loadReceptionistDashboard();
            }

            return true;
        }
        else
        {
            System.out.println("Incorrect password.");
            return false;
        }
    }
}
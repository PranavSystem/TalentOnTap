import Layout from "./Pages/Layout";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Pages/HomePage";
import AboutUs from "./Pages/AboutUs";
import Contact from "./Pages/contact";
import CustomerPage from "./Pages/HomePage/CustomerPage";
import ProfessionalPage from "./Pages/HomePage/ProfessionalPage";
import ProfessionalLoginLayout from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/ProfessionalLoginLayout";
import CreateAppointment from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/CreateAppointment";
import ProfessionalSeeAllTheSlotes from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/ProfessionalSeeAllSlotes";
import ProfessionalUpdateCreatedSlotes from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/ProfessionalUpdateCreatedSlotes";
import ProfessionalSeeAllSlotesDayWise from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/ProfessionalSeeAllSlotesDayWiseApointment";
import UpDateProfessionalProfile from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/UpDateProfessionalsProfile";
import CustomerLogin from "./Pages/HomePage/CustomerFolder/CustomerLogin";
import CustomerAfterLoginLayout from "./Pages/HomePage/CustomerFolder/CustomerLoginFolder/CustomerAfterLoginLayout";
import UpdateCustomer from "./Pages/HomePage/CustomerFolder/CustomerLoginFolder/UpdateCustomer";
import BookAppointmentByPinCode from "./Pages/HomePage/CustomerFolder/CustomerLoginFolder/BookAppointmentByPinCode";
import DeleteSlot from "./Pages/HomePage/CustomerFolder/CustomerLoginFolder/DeleteSlotes";
import ProfessionalReister from "./Pages/HomePage/ProfessionalFolder/ProfessionalRegister";
import AdminPageLayout from "./Pages/HomePage/AdminFolder/AdminPageLayout";
import AcceptNewProfessional from "./Pages/HomePage/AdminFolder/AcceptNewProfessional";
import CreateAdmin from "./Pages/HomePage/AdminFolder/CreateAdmin";
import DeleteProfessional from "./Pages/HomePage/AdminFolder/DeleteProfessional";
import UpdateSlotes from "./Pages/HomePage/CustomerFolder/CustomerLoginFolder/UpdateSlote";
// import ProfessionalLayout from './Pages/HomePage/ProfessionalFolder/ProfessionalLayout';
import AdminPage from "./Pages/HomePage/AdminFolder/AdminPage";
import ProfessionalLogin from "./Pages/HomePage/ProfessionalFolder/Login/ProfessionalLogin";
import ProfessionalRegister from "./Pages/HomePage/ProfessionalFolder/ProfessionalRegister";
import RegisterCustomer from "./Pages/HomePage/CustomerFolder/RegisterCustomer";
import AddProfilePic from "./Pages/HomePage/CustomerFolder/AddProfilePic";
import HomePage from "./Pages/HomeP";
import SeeDateWiseBookAppointment from "./Pages/HomePage/ProfessionalFolder/ProfessionalLoginFolder/SeeDateWiseBookedAppointment";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="AboutUs" element={<AboutUs />} />
          <Route path="Contact" element={<Contact />} />
          <Route path="/CustomerPage" element={<CustomerPage />} />
          <Route path="/ProfessionalPage" element={<ProfessionalPage />} />
          <Route path="/ProfessionalLogin" element={<ProfessionalLogin />} />
          <Route path="/CustomerLogin" element={<CustomerLogin />} />
          <Route
            path="/CustomerAfterLoginLayout"
            element={<CustomerAfterLoginLayout />}
          />
          <Route path="/DeleteSlot" element={<DeleteSlot />} />
          <Route
            path="/ProfessionalRegister"
            element={<ProfessionalReister />}
          />
          <Route path="/UpdateSlotes" element={<UpdateSlotes />} />

          <Route
            path="/BookAppointmentByPinCode"
            element={<BookAppointmentByPinCode />}
          />
          <Route
            path="/ProfessionalLoginLayout"
            element={<ProfessionalLoginLayout />}
          />
          <Route path="/CreateAppointment" element={<CreateAppointment />} />
          <Route
            path="/ProfessionalSeeAllTheSlotes"
            element={<ProfessionalSeeAllTheSlotes />}
          />
          <Route
            path="/ProfessionalUpdateCreatedSlotes"
            element={<ProfessionalUpdateCreatedSlotes />}
          />
          <Route
            path="/ProfessionalSeeAllSlotesDayWise"
            element={<ProfessionalSeeAllSlotesDayWise />}
          />
          <Route
            path="/UpDateProfessionalProfile"
            element={<UpDateProfessionalProfile />}
          />
          <Route path="/UpdateCustomer" element={<UpdateCustomer />} />
          <Route path="/AdminPageLayout" element={<AdminPageLayout />} />
          <Route
            path="/AcceptNewProfessional"
            element={<AcceptNewProfessional />}
          />
          <Route path="/CreateAdmin" element={<CreateAdmin />} />
          <Route path="/DeleteProfessional" element={<DeleteProfessional />} />
          {/* <Route path="/ProfessionalLayout" element={<ProfessionalLayout/>} /> */}
          <Route path="/AdminPage" element={<AdminPage />} />
          <Route
            path="/ProfessionalRegister"
            element={<ProfessionalRegister />}
          />
          <Route path="/RegisterCustomer" element={<RegisterCustomer />} />
          <Route path="/AddProfilePic" element={<AddProfilePic />} />
          <Route path="/Home" element={<HomePage />} />
          <Route
            path="/SeeDateWiseBookAppointment"
            element={<SeeDateWiseBookAppointment />}
          />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

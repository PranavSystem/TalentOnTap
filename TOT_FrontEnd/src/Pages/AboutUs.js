import "./about.css";
const AboutUs = () => {
  return (
    <>
      <div className="about-section container mt-5 w-75">
        <h1 className="text-black  display-4 fw-bolder mt-0 mb-5 ">About Us</h1>
        <div className="mt-4 h6">
          <p>
            Talent On Tap is an on-demand home service providing web application
            that connects homeowners with vetted and reliable service providers
            for a variety of tasks, such as cleaning, repairs, and maintenance.
            With Talent On Tap, you can get the help you need with your home
            quickly and easily, without the hassle.
          </p>
          <p>
            Some additional functionalities are - Customers can search
            professionals by specialization and city, both customers and
            professionals can manage their booked appointments, both can manage
            their appointment history, verification of Professional's
            credentials by admin.
          </p>
        </div>
      </div>
    </>
  );
};
export default AboutUs;

import {useNavigate} from "react-router-dom";

export default function ProjectCard({ project }) {
  const navigate = useNavigate();
  return (
    <div className="col-md-6">
      <div className="card mb-3">
        <div className="card-body">
          <div className="d-flex justify-content-between align-items-center">
            <h5 className="card-title">{project.name}</h5>

            <button className="btn btn-light" onClick={() => {
              navigate(`/projects/${project.id}`);
            }} >
              View
            </button>
          </div>
          <p className="small">
            Status: <strong>{project.status}</strong>
          </p>
        </div>
      </div>
    </div>
  );
}
